package se.nio2;

import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio2Path {
	private static Path userHome = Paths.get(System.getProperty("user.home"));
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkElementIndex(2, args.length);
		Path path = Paths.get(args[0], args[1], args[2]); 
		System.out.printf("Path %s\n", userHome);
		System.out.printf("Path Name Count %d\n", userHome.getNameCount());
		System.out.printf("Path FileName %s\n", userHome.getFileName());
		System.out.printf("Path FileSystem %s\n", userHome.getFileSystem());
		System.out.printf("Path Parent %s\n", userHome.getParent());
		System.out.printf("Relativized Path %s\n", userHome.relativize(userHome.getParent()));
		System.out.printf("Path Root %s\n", userHome.getRoot());
		System.out.printf("Path Resolve %s\n", userHome.resolve("tmp"));
	}

}
