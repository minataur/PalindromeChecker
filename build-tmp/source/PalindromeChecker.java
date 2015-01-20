import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public boolean palindrome(String word)
{
  word = noCapitals(word);
  word = noSpaces(word);
  word = isLetters(word);

  String backward = "";
  int zed = word.length()-1;

  for (int i = 0; i < word.length()/2; i++) {
    if (word.charAt(i) != word.charAt(zed)) {
       return false;
    } else {
      zed--;
    }

  }

  return true;
}

public String noSpaces(String sWord){
  String la = "";
  for (int i = 0; i < sWord.length(); i++) {
     if (sWord.charAt(i) != ' ') {
        la = la + sWord.charAt(i);
     }
  }
  
  return la;
}

public String isLetters(String word){
  String letter = "";
  for ( int i = 0; i < word.length(); i++) {
     if ( Character.isLetter(word.charAt(i))== true) {
       letter = letter + word.charAt(i);
     }
  }
  
  return letter;
}

public String noCapitals(String sWord){
  
  return sWord.toLowerCase();
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
