package com.ui.pojo;

public class Environment {
	private String url;
	private int MAX_NUM_OF_ATTEMPTS;
	
		public int getMAX_NUM_OF_ATTEMPTS() {
		return MAX_NUM_OF_ATTEMPTS;
	}

	public void setMAX_NUM_OF_ATTEMPTS(int mAX_NUM_OF_ATTEMPTS) {
		MAX_NUM_OF_ATTEMPTS = mAX_NUM_OF_ATTEMPTS;
	}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url=url;
		}
}
