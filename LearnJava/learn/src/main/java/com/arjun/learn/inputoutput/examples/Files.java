package com.arjun.inputoutput.examples;

import com.arjun.inputoutput.FilesIntroduction;

import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Files {
    public void getCurrentWorkingDirectory() {
        System.out.println("Current working directory is : " + System.getProperty("user.dir"));
    }

    // Example function to obtain all files in a directory and its subdirectories
    public List<File> getAllFiles(File rootDir) {
        File[] children = rootDir.listFiles();
        if (children == null || children.length == 0) {
            return Collections.emptyList();
        }

        List<File> files = new ArrayList<>();
        for (File child : children) {
            if (child.isDirectory()) {
                files.addAll(getAllFiles(child));
            } else {
                files.add(child);
            }
        }

        return files;
    }

    public void findEmptyFilesInSubdirectory() {
        File baseDir = new File("C:\\Users\\arkhera\\Downloads\\basedir");
        File[] files = baseDir.listFiles();

        Function<File, List<String>> findEmptyDirectories = file -> Arrays.stream(Objects.requireNonNull(file.listFiles()))
                .filter(File::isDirectory)
                .filter(subDirectory -> Objects.requireNonNull(subDirectory.listFiles()).length == 0)
                .map(File::getName)
                .collect(Collectors.toList());

        List<String> names = new ArrayList<>();
        Arrays.stream(files).forEach(file -> names.addAll(findEmptyDirectories.apply(file)));
        names.forEach(name -> System.out.print(name + " "));
    }

    public void findDirectoryWithMaximumFiles() {
        File baseDir = new File("C:\\Users\\arkhera\\Downloads\\basedir");
        File[] files = baseDir.listFiles();

        AtomicInteger maxCount = new AtomicInteger(0);
        AtomicReference<String> directoryName = new AtomicReference<>();

        Arrays.stream(files).forEach(file -> {
            int currentCount = file.listFiles().length;
            if(currentCount > maxCount.get()) {
                maxCount.set(currentCount);
                directoryName.set(file.getName());
            }
        });
        System.out.println(directoryName.get() + " " + maxCount.get());
    }

    public static void findFileNameMaxDepth() {
        File baseDir = new File("C:\\Users\\arkhera\\Downloads\\basedir");
        Pair result = depthFirstSearch(baseDir);
        System.out.println(result.name + " " + result.depth);
    }

    public static class Pair {
        int depth;
        String name;

        Pair(int depth, String name) {
            this.depth = depth;
            this.name = name;
        }
    }

    public static Pair depthFirstSearch(File root) {
        if(root.isFile() || root.listFiles().length == 0) {
            return new Pair(1, root.getName());
        }

        File[] files = root.listFiles();
        Pair maxForThisNode = new Pair(-1, "");
        for(int i = 0; i < files.length; i++) {
            Pair childPair = depthFirstSearch(files[i]);
            if(childPair.depth > maxForThisNode.depth) {
                maxForThisNode.depth = childPair.depth;
                maxForThisNode.name = childPair.name;
            }
        }

        maxForThisNode.depth += 1;
        return maxForThisNode;
    }

}
