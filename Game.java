import java.util.*;

class Game {
  
int wrongCount;
  ArrayList<String> letterList = new ArrayList<>();
  
  public Game() {
    this.wrongCount = 0;
  }

public String getRandom(String[] array) {
    int rnd = new Random().nextInt(array.length);
    return array[rnd];
}

  public void startGame(){
    wrongCount = 0;
    String guessWord = returnCountry();
    String nextWord = printWord(guessWord);
    while(wrongCount<8/*max guesses*/){
      nextWord = letterGuess(guessWord, nextWord);
      System.out.println(nextWord);
      if (nextWord.equals(guessWord)){
        break;
      }
    }
    System.out.println("The Correct Word is " + guessWord);
    System.out.println("If you would like to play again, press 1");
    Scanner sc = new Scanner(System.in);
    boolean valid = false;
    int input = 0;
    while (!valid) {
      if (sc.hasNextInt() /* sc.nextInt() == 1*/) {
        input = sc.nextInt();
        if(input == 1){
          break;
        }
      } else {
        System.out.print("Not a legitimate number!");
        sc.next();
      }
    }
    if (input == 1) {
      Game game = new Game();
      game.startGame();
    }
  }

  public String printWord(String word){
    String spaces = "";
    for(int i = 0; i<word.length(); i++){
      spaces += "_";
    }
    String reWord = "";
    String inputUp = " ";
    for(int i = 0; i<word.length(); i++){
      String currentLett = word.substring(i,i+1);
      if(inputUp.equals(currentLett)){
        reWord+=inputUp;
      }else{
        reWord+=spaces.substring(i,i+1);
      }
    }
    System.out.println(reWord);
    return reWord;
  }

  public String letterGuess(String guessWord, String nextWord){
    Boolean letterCheck = false;
    String input = "";
    while(!letterCheck){
      Scanner sc = new Scanner(System.in);
      input = sc.nextLine();
      if(input.length() == 1 &&Character.isLetter(input.charAt(0))){
        letterCheck = true;
      }
    }
    String inputUp = input.toUpperCase();
    String currentLett = "";
    String reWord = "";
    boolean isInWord = false;
    for(int i = 0; i<guessWord.length(); i++){
      currentLett = guessWord.substring(i,i+1);
      if(inputUp.equals(currentLett)){
        reWord+=inputUp;
        isInWord = true;
      }else{
        reWord+=nextWord.substring(i,i+1);
      }
    }
    if(!isInWord && !letterList.contains(inputUp)){
      wrongCount++;
      letterList.add(inputUp);
      System.out.println("your incorrect guesses are: " + letterList);
    }
    return reWord;
  }

    // public String[] append( String newL ) {
    //   letterList = Arrays.copyOf(letterList, letterList.length + 1);
    //   letterList[letterList.length - 1] = newL; // Assign 40 to the last element
    //   System.out.println(Arrays.toString(letterList));
    //   return letterList;
    // }


public String returnCountry(){
  String[] countries = {"AFGHANISTAN", "ALBANIA", "ALGERIA", "ANDORRA", "ANGOLA", "ANTIGUA AND BARBUDA", "ARGENTINA", "ARMENIA", "AUSTRALIA", "AUSTRIA", "AZERBAIJAN", "THE BAHAMAS", "BAHRAIN", "BANGLADESH", "BARBADOS", "BELARUS", "BELGIUM", "BELIZE", "BENIN", "BHUTAN", "BOLIVIA", "BOSNIA AND HERZEGOVINA", "BOTSWANA", "BRAZIL", "BRUNEI", "BULGARIA", "BURKINA FASO", "BURUNDI", "CABO VERDE", "CAMBODIA", "CAMEROON", "CANADA", "CENTRAL AFRICAN REPUBLIC", "CHAD", "CHILE", "CHINA", "COLOMBIA", "COMOROS", "DEMOCRATIC REPUBLIC OF THE CONGO", "REPUBLIC OF THE CONGO", "COSTA RICA", "COTE DIVOIRE", "CROATIA", "CUBA", "CYPRUS", "CZECH REPUBLIC", "DENMARK", "DJIBOUTI", "DOMINICA", "DOMINICAN REPUBLIC", "EAST TIMOR", "ECUADOR", "EGYPT", "EL SALVADOR", "EQUATORIAL GUINEA", "ERITREA", "ESTONIA", "ESWATINI", "ETHIOPIA", "FIJI", "FINLAND", "FRANCE", "GABON", "THE GAMBIA", "GEORGIA", "GERMANY", "GHANA", "GREECE", "GRENADA", "GUATEMALA", "GUINEA", "GUINEA-BISSAU", "GUYANA", "HAITI", "HONDURAS", "HUNGARY", "ICELAND", "INDIA", "INDONESIA", "IRAN", "IRAQ", "IRELAND", "ISRAEL", "ITALY", "JAMAICA", "JAPAN", "JORDAN", "KAZAKHSTAN", "KENYA", "KIRIBATI", "NORTH KOREA", "SOUTH KOREA", "KOSOVO", "KUWAIT", "KYRGYZSTAN", "LAOS", "LATVIA", "LEBANON", "LESOTHO", "LIBERIA", "LIBYA", "LICHTENSTEIN", "LITHUANIA", "LUXEMBOURG", "MADAGASCAR", "MALAWI", "MALAYSIA", "MALDIVES", "MALI", "MALTA", "MARSHALL ISLANDS", "MAURITANIA", "MAURITIUS", "MEXICO", "FEDERATED STATES OF MICRONESIA", "MOLDOVA", "MONACO", "MONGOLIA", "MONTENEGRO", "MOROCCO", "MOZAMBIQUE", "MYANMAR", "NAMIBIA", "NAURU", "NEPAL", "NETHERLANDS", "NEW ZEALAND", "NICARAGUA", "NIGER", "NIGERIA", "NORTH MACEDONIA", "NORWAY", "OMAN", "PAKISTAN", "PALAU", "PANAMA", "PAPUA NEW GUINEA", "PARAGUAY", "PERU", "PHILIPPINES", "POLAND", "PORTUGAL", "QATAR", "ROMANIA", "RUSSIA", "RWANDA", "SAINT KITTS AND NEVIS", "SAINT LUCIA", "SAINT VINCENT AND THE GRENADINES", "SAMOA", "SAN MARINO", "SAO TOME AND PRINCIPE", "SAUDI ARABIA", "SENEGAL", "SERBIA", "SEYCHELLES", "SIERRA LEONE", "SINGAPORE", "SLOVAKIA", "SLOVENIA", "SOLOMON ISLANDS", "SOMALIA", "SOUTH AFRICA", "SPAIN", "SRI LANKA", "SUDAN", "SOUTH SUDAN", "SURINAME", "SWEDEN", "SWITZERLAND", "SYRIA", "TAIWAN", "TAJIKISTAN", "TANZANIA", "THAILAND", "TOGO", "TONGA", "TRINIDAD AND TOBAGO", "TUNISIA", "TURKEY", "TURKMENISTAN", "TUVALU", "UGANDA", "UKRAINE", "UNITED ARAB EMIRATES", "UNITED KINGDOM", "UNITED STATES", "URUGUAY", "UZBEKISTAN", "VANUATU", "VATICAN CITY", "VENEZUELA", "VIETNAM", "YEMEN", "ZAMBIA", "ZIMBABWE"};
  String country = getRandom(countries);
  return country;
  }
}