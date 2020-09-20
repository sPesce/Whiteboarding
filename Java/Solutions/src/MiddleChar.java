class MiddleChar{
  public static String getMiddle ( String word ) {
    
    final int wordLength = word.length();
    final boolean even = wordLength % 2 == 0;
    final int half = even ? wordLength/2 : ( wordLength - 1 ) / 2;

    if ( even ) return word.substring( half - 1 , half + 1 );
    else return Character.toString( word.charAt( half ) );
  }
}