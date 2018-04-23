package util;

public class MyLogger {

	
	public static enum DebugLevel {
		SEMANTIC_FOUND, NAIVE_FOUND, EXACT_FOUND, CONSTRUCTOR, NONE
	};

	private static DebugLevel debugLevel;

	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 1:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 2:
			debugLevel = DebugLevel.SEMANTIC_FOUND;
			break;
		case 3:
			debugLevel = DebugLevel.NAIVE_FOUND;
			break;
		case 4:
			debugLevel = DebugLevel.EXACT_FOUND;
			break;
		default:
			debugLevel = DebugLevel.NONE;
			break;
		}
	}

	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	// @return None
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/**
	 * @return String
	 */
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}