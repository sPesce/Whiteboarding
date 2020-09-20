class MiddleChar{
  public static String getMiddle(String word) {
    
    final int wordLength = word.length();
    final boolean even = wordLength % 2 == 0;

    char[] letters = new char[even ? 2 : 1];
    if(!even)
      letters[0] = word.charAt((wordLength - 1) / 2);
    else
    {
      final int first = wordLength/2 - 1;
      letters[0] = word.charAt(first);
      letters[1] = word.charAt(first + 1);
    }
    return String.valueOf(letters);
  }
}