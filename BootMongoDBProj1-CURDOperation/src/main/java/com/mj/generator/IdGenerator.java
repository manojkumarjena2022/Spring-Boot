package com.mj.generator;

import java.util.UUID;

public class IdGenerator {
	public static String generateId()
	{
		return UUID.randomUUID().toString().replace("_", "").substring(0, 10);
	}
}
