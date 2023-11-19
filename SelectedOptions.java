package application.org;
	public class SelectedOptions extends Chatbot {
		 final int level;
		private final int choice;
		SelectedOptions(int level, int choice) {
			this.level = level;
			this.choice = choice;
		}
		public int getChoice() {
			return choice;
		}
	}

