package se.nio2;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.file.StandardCopyOption.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import static java.nio.file.LinkOption.*;

import java.nio.file.FileStore;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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
		try(BufferedWriter writer = Files.newBufferedWriter(filePath, charset,StandardOpenOption.CREATE)) {
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkNotNull(args[0], "empty args");
		Nio2File nio2File =  new Nio2File();
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

			Path movePath = nio2File.homePath.resolve("fileMove.txt");
			Files.move(copyPath, movePath, REPLACE_EXISTING);	
			
			Files.delete(nio2File.filePath); // silent if file doesn't exist
			Files.deleteIfExists(copyPath);
			if(Files.exists(movePath, NOFOLLOW_LINKS)) {
				Files.delete(movePath);
			}
		} catch (IOException e) {
			System.err.format(e.getClass().getSimpleName() + ":%s%n", e);
		}

	}

}
