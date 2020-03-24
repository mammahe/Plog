<h2><strong>Print Android Framework</strong></h2>
<p>Goal is to print android framework logs in logcar</p>
<h2><strong>Requirements</strong></h2>
<p>Android 4.0 or higher&nbsp;</p>
<h2><strong> Usage</strong></h2>
<h4><strong>Step 1.&nbsp;</strong>Add it in your root build.gradle at the end of repositories:</h4>
<pre class="kode language-css code-toolbar"><code class=" kode language-css"><span class="token selector">allprojects</span> <span class="token punctuation">{</span>
		<span class="token selector">repositories</span> <span class="token punctuation">{</span>
			<span class="token selector">...
			maven</span> <span class="token punctuation">{</span> url <span class="token string">'https://jitpack.io'</span> <span class="token punctuation">}</span>
		<span class="token punctuation">}</span>
	<span class="token punctuation">}<br /><br /></span></code></pre>
<p><strong>Step 2.&nbsp;Add the dependency</strong></p>
<pre class="kode code-toolbar  language-css"><code id="depCodeGradle" class=" kode  language-css"><span class="token selector">dependencies</span> <span class="token punctuation">{</span>
	        implementation <span class="token string">'com.github.mammahe:Plog:1'</span>
	<span class="token punctuation">}</span></code></pre>
<p><strong>Step 3. Add import in activity</strong></p>
<pre>import com.example.logfilter.PLog;</pre>
<p><strong>Step 4. Example usage in activity</strong></p>
<pre>PLog.v("P Log V");</pre>
<pre>PLog.d("P Log D");</pre>
<pre>PLog.i("P Log I");</pre>
<pre>PLog.w("P Log W");</pre>
<pre>PLog.e("P Log E");</pre>

<h2>Output</h2>
<p><pre>2020-03-24 10:29:30.360 10025-10025/com.example.myapplication V/com.example.myapplication.MainActivity: 2020-03-24 10:29:30.359 com.example.myapplication.MainActivity#onCreate:18 P Log V</pre></p>
<p><pre>2020-03-24 10:29:30.361 10025-10025/com.example.myapplication V/com.example.myapplication.MainActivity: 2020-03-24 10:29:30.360 com.example.myapplication.MainActivity#onCreate:19 P Log D</pre></p>
<p><pre>2020-03-24 10:29:30.362 10025-10025/com.example.myapplication V/com.example.myapplication.MainActivity: 2020-03-24 10:29:30.361 com.example.myapplication.MainActivity#onCreate:20 P Log I</pre></p>
<p><pre>2020-03-24 10:29:30.363 10025-10025/com.example.myapplication V/com.example.myapplication.MainActivity: 2020-03-24 10:29:30.362 com.example.myapplication.MainActivity#onCreate:21 P Log W</pre></p>
<p><pre>2020-03-24 10:29:30.364 10025-10025/com.example.myapplication V/com.example.myapplication.MainActivity: 2020-03-24 10:29:30.363 com.example.myapplication.MainActivity#onCreate:22 P Log E</pre></p>
<h2>License</h2>
<p>Copyright 2019 Sairamkrishna Mammahe</p>
<p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at</p>
<p>http://www.apache.org/licenses/LICENSE-2.0</p>
<p>Unless required by applicable law or agreed to in writing, software under the License is distributed on an "AS IS" BASIS, WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. the License for the specific language governing permissions and under the License.</p>
