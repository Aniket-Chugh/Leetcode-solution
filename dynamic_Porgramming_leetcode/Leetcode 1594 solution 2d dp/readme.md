<h1 align="center">📌 Maximum Product Path in a Grid</h1>

<hr/>

<h2>🧩 Problem Statement</h2>
<p>
Given a <b>m x n</b> grid filled with integers, find a path from the 
<b>top-left</b> to the <b>bottom-right</b> corner such that:
</p>

<ul>
  <li>You can only move <b>right</b> or <b>down</b></li>
  <li>The <b>product of all numbers along the path is maximized</b></li>
</ul>

<p>
Return the <b>maximum non-negative product modulo (10<sup>9</sup> + 7)</b>.<br/>
If the maximum product is negative, return <code>-1</code>.
</p>

<hr/>

<h2>🌍 Real-World Analogy</h2>
<p>
Think of a financial journey where:
</p>
<ul>
  <li>Each cell is a <b>profit (+)</b> or <b>loss (-)</b></li>
  <li>You can only move forward (right/down)</li>
  <li>Your goal is to <b>maximize total wealth (product)</b></li>
</ul>

<p>
💡 Sometimes taking a loss can lead to a bigger gain later!
</p>

<hr/>

<h2>❗ Why Not Greedy?</h2>
<p>
Greedy would pick the largest number at each step, but:
</p>
<ul>
  <li>Negative numbers can flip signs</li>
  <li>Local best choice may lead to global worst</li>
</ul>

<p><b>❌ Greedy fails</b></p>

<hr/>

<h2>❗ Why Not Recursion?</h2>
<ul>
  <li>Each cell → 2 choices (right/down)</li>
  <li>Total paths ≈ 2^(m+n)</li>
</ul>

<p><b>❌ Exponential time → TLE</b></p>

<hr/>

<h2>✅ Why Dynamic Programming?</h2>
<ul>
  <li>Overlapping subproblems ✔️</li>
  <li>Optimal substructure ✔️</li>
</ul>

<p>
Each cell depends on top and left → perfect for DP.
</p>

<hr/>

<h2>⚠️ Key Insight</h2>
<p>
We must track <b>two values</b> at each cell:
</p>

<ul>
  <li><code>maxProduct[i][j]</code></li>
  <li><code>minProduct[i][j]</code></li>
</ul>

<p>
Because:
<br/>
<b>Negative × Negative = Positive</b> 🔥
</p>

<hr/>

<h2>🧠 DP Transition</h2>

<pre>
val = grid[i][j]

Possible:
topMax * val
topMin * val
leftMax * val
leftMin * val

max = maximum of all
min = minimum of all
</pre>

<hr/>

<h2>🧱 Base Case</h2>

<pre>
dp[0][0] = grid[0][0]
</pre>

<hr/>

<hr/>

<h2>⏱️ Complexity</h2>

<table>
  <tr>
    <th>Type</th>
    <th>Complexity</th>
  </tr>
  <tr>
    <td>Time</td>
    <td>O(m × n)</td>
  </tr>
  <tr>
    <td>Space</td>
    <td>O(m × n)</td>
  </tr>
</table>

<hr/>

<h2>🧪 Example</h2>

<pre>
Input:
[[1,-2,1],
 [1,-2,1],
 [3,-4,1]]

Output:
8
</pre>

<hr/>

<h2>🏁 Final Takeaways</h2>

<ul>
  <li>Greedy fails due to negatives</li>
  <li>Track both min & max</li>
  <li>Classic DP with twist</li>
</ul>

<hr/>

<h2>⭐ Pro Tip</h2>
<p>
Whenever you see:
</p>
<ul>
  <li>Product</li>
  <li>Negative numbers</li>
</ul>

<p>
👉 Think: <b>Track both min & max</b>
</p>

<hr/>

<p align="center">🔥 Happy Coding 🔥</p>
