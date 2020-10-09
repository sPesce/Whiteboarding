// -==========================================================================
// Purpose: create the table rows in this projects readme
//  --------------
//  title: The first column of the table, what is this kata?
//  solutionUrl: 2nd col, full github url to solution
//  kataUrl: 3rd col, kata's full url on codewars
//  --------------
//  output: poorly formatted html to the console, but it saves some time
//-===========================================================================
public class GenerateTableRow {
  public static String make(String title, String solutionUrl, String kataUrl)
  {
    String str = 
    "<tr>\n" +
    "  <td><strong>" + title + "</strong></td>\n" +
    "  <td>\n" +
    "    <a href=\"" + solutionUrl + "\">\n" +
    "      solution\n" +
    "    </a>\n" +
    "  </td>\n" +
    "  <td>\n" +
    "    <a href=\"" + kataUrl + "\">\n" +
    "      kata\n" +
    "    </a>\n" +
    "  </td>\n" +
    "</tr>\n";
    return str;
  }
}
