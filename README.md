#Home assignment

Given three strings, text, prefixString, and suffixString, find:

● prefixScore: the longest substring of text matching the end of prefixString
● suffixScore: the longest substring of text matching the beginning of suffixString.
Sum the lengths of the two strings to get the textScore. The substring of text that begins with
the matching prefix and ends with a matching suffix, and has the highest textScore, is the
correct value to return. If there are other substrings with equal textScore, return the
lexicographically lowest substring.

###Example
text = "engine"
prefixString = "raven"
suffixString = "ginkgo":

● engine matches raven, so prefixScore = 2
● engine matches ginkgo, so suffixScore = 3
● textScore = prefixScore + suffixScore = 2 + 3 = 5
● The substring of text with the highest textScore is engin.

###Constraints

● text, prefixString, and suffixString contain lowercase English alphabetic letters
ascii[a-z] only.
● 1 ≤ |text|, |prefixString|, |suffixString| ≤ 50 (here | | means length of)
● It is guaranteed that there will always be a substring of text that matches at least
one of the following:
○ One or more characters at the end of prefixString.
○ One or more characters at the beginning of suffixString.

Input Format for Custom Testing
Input from stdin will be processed as follows and passed to the function.

The first line contains a string text.
The next line contains a string prefixString.
The last line contains a string suffixString.

###Sample Case 0
Sample Input

STDIN Function
----- -----
nothing → text = "nothing"
bruno → prefixText = bruno
ingenious → suffixText = ingenious

Sample Output
nothing

Explanation

● nothing matches bruno, so prefixScore = 2
● nothing matches ingenious, so suffixScore = 3
● textScore = prefixScore + suffixScore = 2 + 3 = 5

The substring of text with the highest textScore begins with the prefix no and ends with the
suffix ing: nothing.

###Sample Case 1
Sample Input

STDIN Function
----- -----
ab → text = "ab"
b → prefixString = "b"

a → suffixString = "a"

Sample Output
a

Explanation
Given text = "ab", our possible substrings are sub = "a", sub = "b", and sub = "ab".

● sub = "a"
○ prefixString = "b": The beginning of sub doesn't match the end of
prefixString, so prefixScore = 0.
○ suffixString = "a": The last character of sub matches the first character of
suffixString, so suffixScore = 1.
○ textScore = prefixScore + suffixScore = 0 + 1 = 1
● sub = "b"
○ prefixString = "b": The first character of sub matches the last character of
prefixString, so prefixScore = 1.
○ suffixString = "a": The end of sub doesn't match the beginning of
suffixString, so suffixScore = 0.
○ textScore = prefixScore + suffixScore = 1 + 0 = 1
● sub = "ab"
○ prefixString = "b": The beginning of sub doesn't match the end of
prefixString, so prefixScore = 0.
○ suffixString = "a": The last character of sub doesn't match the first character
of suffixString, so suffixScore = 0.
○ textScore = prefixScore + suffixScore = 0 + 0 = 0

Two of these have a textScore of 1, so we return the lexicographically smallest one (i.e., "a").

Good Luck :)