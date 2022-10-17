import java.util.Scanner;
class A{

    int count=0;
    String[] words= {"penguin","boomer","dinosaur","funny","galaxy","galvanize","gnarly","gnostic","gossip","grogginess","hyphen","icebox","injury",
		     "ivory","ivy","jackpot","jaundice","jawbreaker","jaywalk","jazziest","jazzy","jelly","jigsaw","jinx","jiujitsu","jogging","joking",
		     "jovial","joyful","juicy","jukebox","jumbo","kayak","keyhole","khaki","kilobyte","kiwifruit","larynx","lengths","lucky","luxury","matrix",
		     "megahertz","microwave","mnemonic","mystify","nightclub","nowadays","oxygen","pixel","pizza","pneumonia","psyche","puppy","puzzling",
		     "quartz","queue","quixotic","quizzes","rhythm","rickshaw","scratch","snazzy","spritz","squawk","staff","stretch","stronghold","stymied",
		     "subway","swivel","syndrome","thriftless","topaz","transcript","transgress","transplant","unknown","unworthy","unzip","uptown","vaporize",
		     "vodka","vortex","walkway","waltz","wave","wavy","wellspring","wheezy","whiskey","whizzing","whomever","wimpy","witchcraft","wizard",
		     "wristwatch","wyvern","xylophone","yoked","youthful","yummy","zephyr","zigzag","zodiac","zombie","abruptly","absurd","abyss","affix",
		     "askew","avenue","awkward","axiom","azure","blitz","blizzard","boggle","bookworm","boxcar","boxful","crypt","cycle","dizzying","duplex",
		     "dwarves","embezzle","espionage","exodus","faking","fishhook","fixable","flopping","fluffiness","flyby","frazzled","frizzled","fuchsia"};
    String word = words[(int) (Math.random() * words.length)];//chose a word from words array of string
	String asterisk = new String(new char[word.length()]).replace("\0", "*");//store asterisks 
}

class B extends A{          

    public void hang(String guess){
        String newasterisk = "";
        for (int i = 0; i < super.word.length(); i++) {//traversing word
            if(guess.charAt(0)==super.word.charAt(i)){//case1 letter is found in word
                newasterisk += guess.charAt(0);
            }
            else if(super.asterisk.charAt(i)!='*'){
                newasterisk += super.word.charAt(i);
            }
            else{//case3 letter is not found in word
                newasterisk+="*";
            }
        }
        if(newasterisk.equals(super.asterisk)){//compare to determine letter was found or not
            super.count++;
            this.hangmanImage();
        }
        else{
            super.asterisk=newasterisk;
        }
        if(newasterisk.equals(super.word)){
            System.out.println("Congratulations! You win the game.");
        }
    }
    public void hangmanImage() {//function to print hangedman when you lose
		if (super.count == 1) {
			System.out.println("Wrong guess, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (super.count == 2) {
			System.out.println("Wrong guess, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (super.count == 3) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (super.count == 4) {
            System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (super.count == 5) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (super.count == 6) {
			System.out.println("Wrong guess, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (super.count == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("GAME OVER! The word was " + super.word);
		}
    }
}

class Main{
    public static void main(String[] args) {
        A X= new A();
        B Y=new B();
    Scanner sc= new Scanner(System.in);//for taking inputs
    while(Y.count<7 && Y.asterisk.contains("*")){
        System.out.println("guess a letter inside the word:");
        System.out.println(Y.asterisk);
        while (!sc.hasNext("[A-Za-z]+")) {
        System.out.println("ENTER LETTERS TO GUESS");
        sc.next();
    }
    String guess = sc.next();
    Y.hang(guess);
    }
    sc.close();
}
}
