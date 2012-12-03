package se.nio2;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/*
 * Closable close() must be invoked to release a resource 
 * try-with resource handles this
 */
public class Nio2File {
	private Path homePath = Paths.get(System.getProperty("user.home"));
	private Path filePath;
	private Charset charset = Charset.forName("US-ASCII");

	public Nio2File() {

	}

	/*
	 * automatically calls Closable.close() finally block no longer needed
	 */
	public void writeHomeFile() {
		String s = "Nio2File example";
		try(BufferedWriter writer = Files.newBufferedWriter(filePath, charset,CREATE)) {
			writer.write(s, 0, s.length());
		} catch (IOException e) {
			System.err.format(e.getClass().getSimpleName() + ":%s%n", e);
		}
	}

	public void readFile(Path path) {
		try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	public void printFileAttributes(Path path) throws IOException 	{
		Map<String, Object> attributes = Files.readAttributes(path, "*", NOFOLLOW_LINKS);
	
		for(Map.Entry<String, Object> entry : attributes.entrySet()) {
			System.out.format("attribute key %s value %s%n", entry.getKey(), entry.getValue());
		}
	}
	
	public void printFileStoreAttributes(Path path) throws IOException {
		FileStore store = Files.getFileStore(path);

		long total = store.getTotalSpace() / 1024;
		long used = (store.getTotalSpace() -
		             store.getUnallocatedSpace()) / 1024;
		long avail = store.getUsableSpace() / 1024;
		System.out.format("File store total space %d used %d available %d%n", total, used, avail);

	}
	
	public void readWriteChannel(Path path) throws IOException {
		String s = "I was here!\n";
		byte data[] = s.getBytes();
		ByteBuffer out = ByteBuffer.wrap(data);
		Long size = (Long) Files.getAttribute(path, "size"); 

		ByteBuffer copy = ByteBuffer.allocate(size.intValue());//FIX_ME error if(size > Integer.MAX_VALUE)

		try (FileChannel fc = (FileChannel.open(path, READ, WRITE))) {
		    // Read the size in bytes of the original
		    int nread;
		    do { 
		        nread = fc.read(copy);
		    } while (nread != -1 && copy.hasRemaining());

		    // Write "I was here!" at the beginning of the file.
		    //fc.position(0);
		    while (out.hasRemaining())
		        fc.write(out);
		    out.rewind();

		    // Move to the end of the file.  Copy the original bytes to
		    // the end of the file.  Then write "I was here!" again.
		    long length = fc.size();
		    fc.position(length-1);
		    copy.flip();
		    while (copy.hasRemaining())
		        fc.write(copy);
		    while (out.hasRemaining())
		        fc.write(out);
		} catch (IOException x) {
		    System.out.format("I/O Exception: %s%n", x);
		}
	}
	
	public void printRootDirs() {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name: dirs) {
		    System.out.format("Root dir %s%n", name);
		}
	}
	public void createSymbolicLink(Path newLink, Path existingFile) {
		checkArgument(!newLink.toFile().exists(), "newLink is an existing file");
		checkArgument(existingFile.toFile().exists(), "existingFile does not exist");

		try {
		    Files.createSymbolicLink(newLink, existingFile);
		} catch (IOException x) {
		    System.err.println(x);
		} catch (UnsupportedOperationException x) {
		    // Some file systems do not
		    // support adding an existing
		    // file to a directory.
		    System.err.println(x);
		}
	}
	public void printFilesInDir(Path path) {
		checkArgument(path.toFile().isDirectory(), "path arg to printFilesInDir is not a directory");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
		    for (Path file: stream) {
		        System.out.println(file.getFileName());
		    }
		} catch (IOException | DirectoryIteratorException x) {
		    // IOException can never be thrown by the iteration.
		    // In this snippet, it can only be thrown by newDirectoryStream.
		    System.err.println(x);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkNotNull(args[0], "empty args");
		Nio2File nio2File =  new Nio2File();
		nio2File.printRootDirs();
		checkArgument(Files.isDirectory(nio2File.homePath, NOFOLLOW_LINKS), nio2File.homePath + " is not a directory");

		nio2File.filePath = nio2File.homePath.resolve(args[0]);
//		checkArgument(Files.isWritable(nio2File.filePath), nio2File.filePath + " is not a writable file");
		nio2File.writeHomeFile();
		nio2File.readFile(nio2File.filePath);
		try {

			nio2File.printFileAttributes(nio2File.filePath);
			nio2File.printFileStoreAttributes(nio2File.filePath);
			Path copyPath = nio2File.filePath.getParent().resolve("fileCopy.txt");
			System.out.format("fileCopy.txt exists %s%n", Files.exists(copyPath));
			Files.copy(nio2File.filePath, copyPath, REPLACE_EXISTING);
			Path newLink = copyPath.getParent().resolve("copyPathLink.txt");
			nio2File.createSymbolicLink(newLink, copyPath);
			Path movePath = nio2File.homePath.resolve("fileMove.txt");
			Files.move(copyPath, movePath, REPLACE_EXISTING);	
			
			Files.delete(nio2File.filePath); // silent if file doesn't exist
			Files.deleteIfExists(copyPath);
			Files.deleteIfExists(newLink);
			if(Files.exists(movePath, NOFOLLOW_LINKS)) {
				nio2File.readWriteChannel(movePath);
				//Files.delete(movePath);
			}
			
			//nio2File.printFilesInDir(nio2File.homePath);
		} catch (IOException e) {
			System.err.format(e.getClass().getSimpleName() + ":%s%n", e);
		}

	}

}
