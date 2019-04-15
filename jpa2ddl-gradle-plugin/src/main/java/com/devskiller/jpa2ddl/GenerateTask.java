package com.devskiller.jpa2ddl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class GenerateTask extends DefaultTask {

	private GeneratePluginExtension extension;
	private Set<File> outputClassesDirs;

	void setExtension(GeneratePluginExtension extension) {
		this.extension = extension;
	}

	@TaskAction
	public void generateModel() throws Exception {
		getLogger().info("Running schema generation...");
		GeneratorSettings settings = getSettings();
		URL[] urls = outputClassesDirs.stream()
				.map(path -> {
					try {
						return path.toURI().toURL();
					} catch (MalformedURLException e) {
						throw new IllegalStateException("Cannot build URL from sourceSets", e);
					}
				})
				.toArray(URL[]::new);
		ClassLoader originalClassLoader = Thread.currentThread().getContextClassLoader();
		URLClassLoader urlClassLoader = new URLClassLoader(urls, originalClassLoader);
		Thread.currentThread().setContextClassLoader(urlClassLoader);
		new SchemaGenerator().generate(settings);
		Thread.currentThread().setContextClassLoader(originalClassLoader);
		getLogger().info("Schema saved to " + extension.getOutputPath());
	}

  @Input
	GeneratorSettings getSettings() {
    Properties jpap = new Properties();
    jpap.putAll(extension.getJpaProperties());
		return new GeneratorSettings(extension.getGenerationMode(),
				extension.getOutputPath(),
				Arrays.asList(extension.getPackages()),
				extension.getAction(),
				jpap,
				extension.getFormatOutput(),
				extension.getDelimiter(),
				extension.getSkipSequences());
	}

	public void setOutputClassesDirs(Set<File> outputClassesDirs) {
		this.outputClassesDirs = outputClassesDirs;
	}
}
