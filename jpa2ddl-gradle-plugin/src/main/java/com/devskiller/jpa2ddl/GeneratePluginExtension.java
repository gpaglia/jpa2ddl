package com.devskiller.jpa2ddl;

import java.io.File;
import java.util.Map;
import java.util.Properties;

import org.gradle.api.Project;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.MapProperty;
import org.gradle.api.provider.Property;
import org.gradle.api.provider.Provider;

public class GeneratePluginExtension {

	private final Property<File> outputPath;
	private final Property<GenerationMode> generationMode;
	private final Property<String[]> packages;
	private final Property<Action> action;
	private final MapProperty<String, String> jpaProperties;
	private final Property<Boolean> formatOutput;
	private final Property<Boolean> skipSequences;
	private final Property<String> delimiter;

	public GeneratePluginExtension(Project project) {
		ObjectFactory of = project.getObjects();
		outputPath = of.property(File.class);
		generationMode = of.property(GenerationMode.class);
		packages = of.property(String[].class);
		action = of.property(Action.class);
		jpaProperties = of.mapProperty(String.class, String.class);
		formatOutput = of.property(Boolean.class);
		skipSequences = of.property(Boolean.class);
		delimiter = of.property(String.class);
	}

	public File getOutputPath() {
		return outputPath.get();
	}

	public void setOutputPath(File outputPath) {
		this.outputPath.set(outputPath);
	}

	public GenerationMode getGenerationMode() {
		return generationMode.get();
	}

	public void setGenerationMode(GenerationMode generationMode) {
		this.generationMode.set(generationMode);
	}

	public String[] getPackages() {
		return packages.get();
	}

	public void setPackages(String[] packages) {
		this.packages.set(packages);
	}

	public Action getAction() {
		return action.get();
	}

	public void setAction(Action action) {
		this.action.set(action);
	}

	public Map<String, String> getJpaProperties() {
		return jpaProperties.get();
	}

	public void setJpaProperties(Map<String, String> jpaProperties) {
		this.jpaProperties.set(jpaProperties);
	}

	public Boolean getFormatOutput() {
		return formatOutput.get();
	}

	public void setFormatOutput(Boolean formatOutput) {
		this.formatOutput.set(formatOutput);
	}

	public Boolean getSkipSequences() {
		return skipSequences.get();
	}

	public void setSkipSequences(Boolean skipSequences) {
		this.skipSequences.set(skipSequences);
	}

	public String getDelimiter() {
		return delimiter.get();
	}

	public void setDelimiter(String delimiter) {
		this.delimiter.set(delimiter);
	}

	public Provider<File> getOutputPathProvider() {
		return outputPath;
	}

	public Provider<GenerationMode> getGenerationModeProvider() {
		return generationMode;
	}

	public Provider<String[]> getPackagesProvider() {
		return packages;
	}

	public Provider<Action> getActionProvider() {
		return action;
	}

	public Provider<Map<String, String>> getJpaPropertiesProvider() {
		return jpaProperties;
	}

	public Provider<Boolean> getFormatOutputProvider() {
		return formatOutput;
	}

	public Provider<Boolean> getSkipSequencesProvider() {
		return skipSequences;
	}

	public Provider<String> getDelimiterProvider() {
		return delimiter;
	}
}
