
public class JadenCase {
    public String toJadenCase(String phrase) {
        if(phrase == null||phrase.isEmpty()||phrase.isBlank())
            return null;
        
        final int len = phrase.length();
        char[] chars = new char[len];
        chars[0] = Character.toUpperCase(phrase.charAt(0));
        
        for(int i = 1; i < len; i++)
        {
            final char current = phrase.charAt(i);
            final char last = phrase.charAt(i-1);
            if(Character.isLetter(last))
                chars[i] = Character.toLowerCase(current);
            else
                chars[i] = Character.toUpperCase(current);                
        }
        return new String(chars); 
    }
}

/*... Your task is to convert strings to how they would be 
written by Jaden Smith. The strings are actual quotes from Jaden Smith, 
but they are not capitalized in the same way he originally typed them. */