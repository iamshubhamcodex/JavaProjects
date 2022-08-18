package flappyBird;

import java.util.Date;

public class Gravity{
	public static float g = 9.8f; // m/s2
	public static final float a = g;
	public static float t = 0.10f; // s
	public static float vi = 0; // m/s
	public static float vf = a * t; // m/s
	public static float s = (vi * t) + ((a * t * t) / 2.0f); // m
	
	public static long sTime;
	public static Date d;

	public Gravity() {
		d = new Date();
		sTime = d.getTime();
	}
	public static float getTime() {
		Date dn = new Date();
		return (dn.getTime() - sTime) / 1000.0f;
	}
	public static float getVelF() {
		return a * getTime();
	}
	public static float getDist() {
		float f = getTime();
		return (vi * t) +((a * f * f)/2.0f);
	}
	public static void refreshTime() {
		Date dn = new Date();
		sTime = dn.getTime();
	}
	
}
