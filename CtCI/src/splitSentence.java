import javax.print.DocFlavor;
import java.util.*;

public class splitSentence
{
    static class Trie
    {
        Trie[] child = new Trie[32];
        String word = "";
    }
    static void add(String word, Trie t)
    {
        char[] chars = word.toCharArray();
        for(char ch : chars)
        {
            if(t.child[ch-'a'] == null)
                t.child[ch-'a'] = new Trie();
            t = t.child[ch-'a'];
        }
        t.word = word;
    }
    static boolean search(String word, int at, Trie t)
    {
        if(t == null)
            return false;
        if(at == word.length())
            return t.word.equals(word);

        if(word.charAt(at) == '.')
        {
            for(int i = 0; i < 32; i++)
                if(search(word, at+1, t.child[i]))
                    return true;
            return false;
        }
        return search(word, at+1, t.child[word.charAt(at)-'a']);
    }
    static boolean match(String word, Trie t)
    {
        return search(word, 0, t);
    }


    static class Res
    {
        String parsed;
        int junkLen;
        Res(String parsed, int junkLen)
        {
            this.parsed = parsed;
            this.junkLen = junkLen;
        }
    }

    static Res findSplit(String sentence, int at, Trie t, Res[] memo)
    {
        if(at == sentence.length())
            return new Res("", 0);
        if(memo[at] != null)
            return memo[at];

        int minJunkLen = sentence.length();
        String bestParsed = "";
        String partial = "";
        int i = at;
        while (i < sentence.length())
        {
            partial += sentence.charAt(i);
            int junkLen = match(partial, t) ? 0 : partial.length();
            Res rest = findSplit(sentence, i+1, t, memo);
            if(junkLen + rest.junkLen < minJunkLen)
            {
                minJunkLen = junkLen + rest.junkLen;
                bestParsed = partial+" "+rest.parsed;
            }
            if(minJunkLen == 0) break;

            i++;
        }

        memo[at] = new Res(bestParsed, minJunkLen);
        return memo[at];

    }
    public static void main(String[] args)
    {
        Trie trie = new Trie();

        String[] words = new String[] {"this", "find", "it", "interesting",
                                                    "and", "encouraging"};
        for(String w : words)
            add(w, trie);

        String sentence = "findthiscourseinterestingandencouragingsepideh";
        Res res = findSplit(sentence, 0, trie, new Res[sentence.length()]);
        System.out.println(res.parsed);

    }


}
