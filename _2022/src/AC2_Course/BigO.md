<div id="file-content-field-4379640" class="file-content-field">
    <div class="main-martor main-martor-content" data-field-name="content">
        <div class="section-martor">
            <div id="file-martor-field-4379640" class="ui bottom attached tab active martor-preview" data-tab="preview-tab-content">
                <h1>时空复杂度分析</h1>
<h2>时间复杂度</h2>
<p>y总的文章：<a href="https://www.acwing.com/blog/content/32/">由数据范围反推算法复杂度以及算法内容</a></p>
<h3>从代码分析时间复杂度</h3>
<ol>
<li>纯循环，平行的循环用加法，嵌套的循环用乘法</li>
<li>递归 &amp; 迭代<ul>
<li>公式可以看<a href="https://baike.baidu.com/item/%E4%B8%BB%E5%AE%9A%E7%90%86/3463232?fr=aladdin">主定理</a></li>
</ul>
</li>
<li>常见算法分析</li>
<li>基础算法<ol>
<li>快速排序 &amp; 归并排序：每一层复杂度是 $O(n)$ ，一共有 $\log n$ 层</li>
<li>二分 $O(\log n)$</li>
<li>高精度一重循环， $O(n)$</li>
<li>双指针：看似两重循环，但内层循环的指针是单向进行的，最多操作 $n$ 次，因此整体的复杂度是 $O(n)$</li>
</ol>
</li>
<li>数据结构<ol>
<li>单链表：插入和删除都是 $O(1)$</li>
<li>栈与队列的操作都是 $O(1)$</li>
<li>单调栈和单调队列：每个元素都只会进一次，出一次，复杂度是 $O(n)$</li>
<li>KMP:内层嵌套了一个循环 <code>j = ne[j]</code> ，但由于外层每次循环只执行一次 <code>j ++</code> ,因此 <code>j</code> 最多加 <code>n</code> 次。内层循环让 <code>j</code> 减少，总共最多也只能执行 <code>n</code> 次，因此算法整体复杂度是 $O(n)$</li>
<li>trie树：时间复杂度与字符串长度呈线性关系</li>
<li>并查集：加上路径压缩，最坏是 $O(n\log n)$ ，但路径压缩对数据结构进行了优化，因此实际运行效率更快；再加上按秩合并可以到 $O(n\log \log n)$</li>
<li>堆：取堆顶元素，时间复杂度是 $O(1)$ ；<code>up &amp; down</code> 操作与堆高度成正比，是 $O(\log n)$</li>
<li>哈希表：增删改查都是 $O(1)$ ，不用考虑最坏情况</li>
</ol>
</li>
<li>搜索与图论<ol>
<li>dfs:树的结构,最后一层有 $n!$ 个点，循环一次输出答案；倒数第二层有 $(n-1)!$ 个点，循环一次进行遍历；其他层同倒数第二层。因此时间复杂度是每一层的复杂度之和。由于 $n!$ 相比于 $(n-1)!$ 是无穷大量，因此时间复杂度为 $O(n!\times n)$</li>
<li>搜索问题都可以画出树来分析</li>
<li>图的遍历：有判重，所以每个点只遍历一次，时间是 $O(n)$ ；遍历每个点时都要遍历邻接的边，时间总共是 $O(n)$ ；所以总体时间复杂度是 $O(n + m)$</li>
<li>朴素Dijkstra：两重循环，$O(n^{2})$</li>
<li>堆优化Dijkstra:有判重，只会遍历到所有边一次，每次遍历进行一次堆插入，总时间复杂度是 $O(m\log m)$</li>
<li>Bellman-Ford:两重循环，$O(nm)$</li>
<li>spfa:理论时间复杂度是 $O(nm)$ ，可以被卡，但一般运行时都远快于理论时间复杂度（同样情况的还有匈牙利算法和最大流算法）求负环就是真正 $O(mn)$</li>
<li>Floyd:三重循环， $O(n^{3})$</li>
<li>Prim:两重循环，$O(n^{2})$</li>
<li>Kruskal:有一个对边权的排序 $O(m\log m)$，平行一个并查集操作 $O(m)$ ,总体复杂度是 $O(m\log m)$</li>
<li>染色法判断二分图：图的深度或宽度优先遍历，$O(n + m)$</li>
<li>匈牙利算法：对每一个点循环一次需要 $O(n)$ ,每次判断需要遍历所有点的所有边，因此总共是 $O(nm)$ ,而 $m$ 最大等于 $n^{2}$ ,因此算法复杂度最坏是 $O(n^{3})$ ,但实际运行效率非常高</li>
</ol>
</li>
<li>数学<ol>
<li>试除法判定质数 &amp; 分解质因数：$O(\sqrt{x})$</li>
<li>筛素数：埃氏筛法，两重循环，但内层循环总和是一个调和级数，因此时间复杂度是 $O(n\log n)$ ;如果再优化成只让素数去进行内层筛选，则可以优化到 $O(n\log \log n)$</li>
<li>辗转相除法：$O(\log n)$ 且常数较小</li>
<li>快速幂：$O(\log k)$ ，$k$ 为指数</li>
</ol>
</li>
<li>动态规划<ul>
<li>计算量 = 状态数量 $\times$ 状态转移的计算量（计算每个状态需要的计算量）</li>
<li>背包问题直接看循环，或者看状态表示的维数<ul>
<li>完全背包：状态数量 $nm$ $\times$ 状态转移计算量 $O(1)$ = $O(nm)$</li>
<li>多重背包：状态数量 $nv(体积)$ $\times$ 状态转移计算量 $O(n)$ = $O(n^{2}v)$</li>
</ul>
</li>
<li>最长上升子序列的优化：外层循环 $n$ 次，内层循环 $\log n$ 次，因此总体是 $O(n\log n)$</li>
<li>状态压缩DP：看循环，$O(2^{2n}n)$</li>
<li>树形DP<ul>
<li>没有上司的舞会里，把每一条边遍历了一次，$O(n)$</li>
</ul>
</li>
<li>滑雪：两维，状态数量就是 $n^{2}$ ,计算每个状态需要循环 $4$ 次，也就是 $O(1)$ ，因此总时间复杂度就是 $O(n^{2})$</li>
</ul>
</li>
<li>贪心：一般是排序 $O(n\log n)$ + 几重循环</li>
</ol>
<hr />
<h2>空间复杂度</h2>
<h3>单位换算</h3>
<p>1 B(yte) = 8 bit<br />
1 KB = 1024 B<br />
1 MB = 1024 KB<br />
1 GB = 1024 MB</p>
<hr />
<h3>数据类型空间大小</h3>
<p>int : 4 B<br />
char : 1 B<br />
double,long long : 8B<br />
pointer : 32位系统 4B | 64位系统 8B<br />
bool : 1 B<br />
- 为什么不用1 bit? 因为每个数据类型都要通过指针来寻址，而系统寻址的最小单位是Byte，系统无法给一个 bit 创建指针，也无法对 bit 寻址</p>
<hr />
<h3>分析代码空间复杂度</h3>
<p>分析时要注意，计算全局变量的空间复杂度要看实际运行时会用到的空间，而不是总空间，因为全局变量在未被使用时分配的是虚拟内存</p>
<p>当代码里有递归函数或需要大量调用函数时，还需要分析栈空间复杂度。比如快速排序，需要递归 $\log n$ 层，因此空间复杂度是 $O(\log n)$ ;而归并排序在递归时每一层还需要开一个长度为 $n$ 的数组，因此空间复杂度是 $n\log n$</p>
            </div>
        </div><!-- end  /.section-martor -->
    </div>
</div>