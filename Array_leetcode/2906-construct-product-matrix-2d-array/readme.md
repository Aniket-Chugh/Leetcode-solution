<h1>🧮 Construct Product Matrix</h1>

<p><strong>Difficulty:</strong> Medium</p>

<hr>

<h2>📌 Problem Statement</h2>
<p>
Given a 0-indexed 2D integer matrix <code>grid</code> of size <code>n × m</code>, construct a matrix <code>p</code> such that:
</p>
<ul>
  <li>Each element <code>p[i][j]</code> is the product of all elements in <code>grid</code> except <code>grid[i][j]</code></li>
  <li>The result is taken modulo <code>12345</code></li>
</ul>

<hr>

<h2>🧾 Examples</h2>

<h3>Example 1</h3>
<pre>
Input:  grid = [[1,2],[3,4]]
Output: [[24,12],[8,6]]
</pre>

<h3>Example 2</h3>
<pre>
Input:  grid = [[12345],[2],[1]]
Output: [[2],[0],[0]]
</pre>

<hr>

<h2>⚙️ Constraints</h2>
<ul>
  <li>1 ≤ n == grid.length ≤ 10<sup>5</sup></li>
  <li>1 ≤ m == grid[i].length ≤ 10<sup>5</sup></li>
  <li>2 ≤ n × m ≤ 10<sup>5</sup></li>
  <li>1 ≤ grid[i][j] ≤ 10<sup>9</sup></li>
</ul>

<hr>

<h2>💡 Key Observations</h2>
<ul>
  <li>Naive approach is too slow ❌</li>
  <li>Division approach fails with zeros ❌</li>
  <li>Use prefix and suffix products ✅</li>
</ul>

<hr>

<h2>🚀 Approach (Prefix + Suffix)</h2>
<p>
Flatten the 2D matrix into a 1D array and compute:
</p>

<pre>
result[i] = (prefix[i] * suffix[i]) % MOD
</pre>

<ul>
  <li><code>prefix[i]</code> → product before index i</li>
  <li><code>suffix[i]</code> → product after index i</li>
</ul>

<hr>

<h2>⏱️ Complexity</h2>
<ul>
  <li><strong>Time:</strong> O(n × m)</li>
  <li><strong>Space:</strong> O(n × m)</li>
</ul>

<hr>

<h2>⚠️ Common Mistakes</h2>
<ul>
  <li>Using total product (overflow) ❌</li>
  <li>Using division ❌</li>
  <li>Not applying modulo early ❌</li>
  <li>Wrong 2D dimensions ❌</li>
</ul>

<hr>

<h2>🧠 Key Takeaways</h2>
<ul>
  <li>Use prefix + suffix for product problems</li>
  <li>Always apply modulo during multiplication</li>
  <li>Flattening simplifies 2D problems</li>
</ul>

<hr>

<h2>🔗 Related Topics</h2>
<ul>
  <li>Prefix Product</li>
  <li>Modular Arithmetic</li>
  <li>Array Manipulation</li>
</ul>
