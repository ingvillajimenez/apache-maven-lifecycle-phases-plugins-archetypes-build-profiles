package com.mycompany.plugins;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "count-source-lines", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class LineCounterMojo extends AbstractMojo {
	
	@Parameter(property = "sourceDirectory", defaultValue = "${project.build.sourceDirectory}")
	private File sourceDirectory;

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		try {
			long totalLinesOfSourceCode = Files.walk(sourceDirectory.toPath())
					.filter(f -> !f.toFile().isDirectory())
					.mapToLong(f -> newBufferedReader(f).lines().count()).sum();
			getLog().info("There are " + totalLinesOfSourceCode + " lines of source code in this project");
		} catch(IOException e) {
			throw new MojoExecutionException("While counting lines of source code", e);
		}
		
	}

	private BufferedReader newBufferedReader(Path f) {
		try {
			
		} catch(UncheckedIOException e) {
			
		}
	}
}
