package es.uned.aw.ped2025.controller;
/**
 *   
 * 
 * 
 */
public class ChangePasswordRequest {
	private String actualPassword;
	private String newPassword;
	private String repeatPassword;
	
	private ChangePasswordRequest(Builder builder) {
		this.actualPassword = builder.actualPassword;
		this.newPassword = builder.newPassword;
		this.repeatPassword = builder.repeatPassword;
		
	}
	public String getActualPassword() {
		return actualPassword;
	}
	public void setActualPassword(String actualPassword) {
		this.actualPassword = actualPassword;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public static class Builder {
		private  String actualPassword;
		private  String newPassword;
		private  String repeatPassword;
		
		public Builder(String actualPassword, String newPassword, String repeatPassword) {
			this.actualPassword = actualPassword;
			this.newPassword = newPassword;
			this.repeatPassword = repeatPassword;
			
		}
		public Builder actualPassword(String actualPassword) {
			this.actualPassword = actualPassword;
			return this;
		}
		public Builder newPassword(String newPassword) {
			this.newPassword = newPassword;
			return this;
		}
		public ChangePasswordRequest build() {
			return new ChangePasswordRequest(this);
		}
		public Builder repeatPassword(String repeatPassword) {
			this.repeatPassword = repeatPassword;
			return this;
		}
	}
}
