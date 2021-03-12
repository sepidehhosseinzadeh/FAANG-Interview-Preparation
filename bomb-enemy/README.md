<h2>361. Bomb Enemy</h2><h3>Medium</h3><hr><div><p>Given a 2D grid, each cell is either a wall <code>'W'</code>, an enemy <code>'E'</code> or empty <code>'0'</code> (the number zero), return the maximum enemies you can kill using one bomb.<br>
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.<br>
<strong>Note: </strong>You can only put the bomb at an empty cell.</p>

<p><strong>Example:</strong></p>

<div>
<pre><strong>Input: </strong><span id="example-input-1-1">[["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]</span>
<strong>Output: </strong><span id="example-output-1">3 
<strong>Explanation: </strong></span>For the given grid,

0 E 0 0 
E 0 W E 
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.
</pre>
</div></div>