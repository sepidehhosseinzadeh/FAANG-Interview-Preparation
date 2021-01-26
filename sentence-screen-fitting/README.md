<h2>418. Sentence Screen Fitting</h2><h3>Medium</h3><hr><div><p>Given a <code>rows x cols</code> screen and a sentence represented by a list of <b>non-empty</b> words, find <b>how many times</b> the given sentence can be fitted on the screen.
</p>

<p><b>Note:</b>
</p><ol>
<li>A word cannot be split into two lines.</li>
<li>The order of words in the sentence must remain unchanged.</li>
<li>Two consecutive words <b>in a line</b> must be separated by a single space.</li>
<li>Total words in the sentence won't exceed 100.</li>
<li>Length of each word is greater than 0 and won't exceed 10.</li>
<li>1 ≤ rows, cols ≤ 20,000.</li>
</ol>
<p></p>

<p>
<b>Example 1:</b> 
</p><pre><b>Input:</b>
rows = 2, cols = 8, sentence = ["hello", "world"]

<b>Output:</b> 
1

<b>Explanation:</b>
hello---
world---

The character '-' signifies an empty space on the screen.
</pre>
<p></p>

<p>
<b>Example 2:</b> 
</p><pre><b>Input:</b>
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

<b>Output:</b> 
2

<b>Explanation:</b>
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
</pre>
<p></p>

<p>
<b>Example 3:</b> 
</p><pre><b>Input:</b>
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

<b>Output:</b> 
1

<b>Explanation:</b>
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
</pre>
<p></p></div>