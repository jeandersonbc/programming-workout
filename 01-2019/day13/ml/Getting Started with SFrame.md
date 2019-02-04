
# Import GraphLab Create


```python
import graphlab
```

# Loading tabular dataset


```python
sf = graphlab.SFrame('people-example.csv')
```

    [INFO] graphlab.cython.cy_server: GraphLab Create v2.1 started. Logging: /tmp/graphlab_server_1548749360.log


    This non-commercial license of GraphLab Create for academic use is assigned to j.barroscandido@tudelft.nl and will expire on December 30, 2019.



<pre>Finished parsing file /Users/jeandersonbc/projects/programming-workout/day13/ml/people-example.csv</pre>



<pre>Parsing completed. Parsed 7 lines in 0.031753 secs.</pre>


    ------------------------------------------------------
    Inferred types from first 100 line(s) of file as 
    column_type_hints=[str,str,str,int]
    If parsing fails due to incorrect types, you can correct
    the inferred type list above and pass it to read_csv in
    the column_type_hints argument
    ------------------------------------------------------



<pre>Finished parsing file /Users/jeandersonbc/projects/programming-workout/day13/ml/people-example.csv</pre>



<pre>Parsing completed. Parsed 7 lines in 0.0099 secs.</pre>


# SFrame basics


```python
sf # first few lines...
```




<div style="max-height:1000px;max-width:1500px;overflow:auto;"><table frame="box" rules="cols">
    <tr>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">First Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Last Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Country</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">age</th>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Bob</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Smith</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">24</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alice</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Williams</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Canada</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Malcolm</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Jone</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">England</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Felix</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Brown</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">USA</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alex</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Cooper</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Poland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Tod</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Campbell</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Derek</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Ward</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Switzerland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">25</td>
    </tr>
</table>
[7 rows x 4 columns]<br/>
</div>




```python
sf.head()
```




<div style="max-height:1000px;max-width:1500px;overflow:auto;"><table frame="box" rules="cols">
    <tr>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">First Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Last Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Country</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">age</th>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Bob</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Smith</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">24</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alice</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Williams</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Canada</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Malcolm</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Jone</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">England</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Felix</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Brown</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">USA</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alex</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Cooper</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Poland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Tod</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Campbell</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Derek</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Ward</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Switzerland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">25</td>
    </tr>
</table>
[7 rows x 4 columns]<br/>
</div>




```python
sf.tail(n=3)
```




<div style="max-height:1000px;max-width:1500px;overflow:auto;"><table frame="box" rules="cols">
    <tr>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">First Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Last Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Country</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">age</th>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alex</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Cooper</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Poland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Tod</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Campbell</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Derek</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Ward</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Switzerland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">25</td>
    </tr>
</table>
[3 rows x 4 columns]<br/>
</div>



# GraphLab Canvas


```python
sf.show()
```

    Canvas is accessible via web browser at the URL: http://localhost:53155/index.html
    Opening Canvas in default web browser.



```python
graphlab.canvas.set_target('ipynb')
```


```python
sf['age'].show(view='Categorical')
```



# Inspecting columns of dataset


```python
sf['Country']
```




    dtype: str
    Rows: 7
    ['United States', 'Canada', 'England', 'USA', 'Poland', 'United States', 'Switzerland']




```python
sf['age']
```




    dtype: int
    Rows: 7
    [24, 23, 22, 23, 23, 22, 25]




```python
sf['age'].mean()
```




    23.142857142857146




```python
sf['age'].max()
```




    25



# Creating new columns


```python
sf
```




<div style="max-height:1000px;max-width:1500px;overflow:auto;"><table frame="box" rules="cols">
    <tr>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">First Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Last Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Country</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">age</th>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Bob</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Smith</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">24</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alice</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Williams</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Canada</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Malcolm</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Jone</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">England</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Felix</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Brown</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">USA</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alex</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Cooper</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Poland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Tod</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Campbell</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Derek</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Ward</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Switzerland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">25</td>
    </tr>
</table>
[7 rows x 4 columns]<br/>
</div>




```python
# Vectorized operation
sf['Full Name'] = sf['First Name'] + ' ' + sf['Last Name']
```


```python
sf
```




<div style="max-height:1000px;max-width:1500px;overflow:auto;"><table frame="box" rules="cols">
    <tr>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">First Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Last Name</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Country</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">age</th>
        <th style="padding-left: 1em; padding-right: 1em; text-align: center">Full Name</th>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Bob</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Smith</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">24</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Bob Smith</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alice</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Williams</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Canada</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alice Williams</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Malcolm</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Jone</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">England</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Malcolm Jone</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Felix</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Brown</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">USA</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Felix Brown</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alex</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Cooper</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Poland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">23</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Alex Cooper</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Tod</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Campbell</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">United States</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">22</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Tod Campbell</td>
    </tr>
    <tr>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Derek</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Ward</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Switzerland</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">25</td>
        <td style="padding-left: 1em; padding-right: 1em; text-align: center; vertical-align: top">Derek Ward</td>
    </tr>
</table>
[7 rows x 5 columns]<br/>
</div>



# Using the apply function to transform data


```python
sf['Country']
```




    dtype: str
    Rows: 7
    ['United States', 'Canada', 'England', 'USA', 'Poland', 'United States', 'Switzerland']




```python
sf['Country'].show()
```




```python
def normalize(country_name):
    if country_name == "USA":
        return "United States"
    return country_name  # no other rule...
```


```python
sf['Country'].apply(normalize)
```




    dtype: str
    Rows: 7
    ['United States', 'Canada', 'England', 'United States', 'Poland', 'United States', 'Switzerland']




```python
sf['Country']
```




    dtype: str
    Rows: 7
    ['United States', 'Canada', 'England', 'USA', 'Poland', 'United States', 'Switzerland']




```python
sf['Country'] = sf['Country'].apply(normalize)
```


```python
sf['Country']
```




    dtype: str
    Rows: 7
    ['United States', 'Canada', 'England', 'United States', 'Poland', 'United States', 'Switzerland']




```python
sf['Country'].show()
```


