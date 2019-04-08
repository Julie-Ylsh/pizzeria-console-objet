package fr.pizzeria.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExemple {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogExemple.class);

	public static void main(String[] args) {
		LOGGER.warn("L'application vient de démarrer.");

	}
}
