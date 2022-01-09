package com.bridgelabz.moodanalyser;

import org.junit.Test;

import junit.framework.Assert;

public class MoodAnalyserTest {
	@Test
	public void givenMood_IsHappy_ShouldReturnSad() throws MoodAnalysisException {
		MoodAnalyser analyser = new MoodAnalyser("I am in Sad mood");
		Assert.assertEquals("SAD",analyser.analyseMood());
	}
	@Test
	public void givenMood_IsAny_ShouldReturnHappy() throws MoodAnalysisException {
		MoodAnalyser analyser = new MoodAnalyser("I am in Happy mood");
		Assert.assertEquals("HAPPY",analyser.analyseMood());
	}
	@Test
	public void givenMood_IsNull_ShouldReturnMoodAnalysisNullException() throws MoodAnalysisException {
		MoodAnalyser analyser = new MoodAnalyser(null);
		try {
			analyser.analyseMood();
		} catch (MoodAnalysisException e) {
			Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
		}
	}
	@Test
	public void givenMessage_WhenEmpty_ShouldThrowMoodAnalysisEmptyException() {

		MoodAnalyser moodAnalyzer = new MoodAnalyser("");
		try {
			moodAnalyzer.analyseMood();
		} catch (MoodAnalysisException e) {
			Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
		}
	}
}
