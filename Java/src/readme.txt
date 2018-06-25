1.array包下的排序




2018.06.03 
1.工厂模式
2.集合


2.集合
Map 
 --key唯一，对应一个Value
 --提供三种集合类视图
   --keys集  keySet()
   	 --set<k>是由map支持的，修改了map的值，set会跟着变化，反之亦然（迭代器自己的remove操作除外）。 
  	        支持remove操作，不支持add
   --Value集  Collection<v> values()
     --collection<V>是有map映射支持的，map变化collection跟着变化，反之亦然（迭代器自己的remove操作除外）。 。
                   支持remove操作，不支持add
   --key-value映射集 entrySet()
     --Set<Map.EntrySet<k,v>>是有map映射支持的，map变化collection跟着变化，反之亦然（迭代器自己的remove操作除外）。 。
                   支持remove操作，不支持add
 
 HashMap <-> Hashtable
 HashMap 非同步方法，键、值可以为null
 HashMap的性能：初始容量、加载因子是影响其性能的两个因素 ，当map中的条目超过容量和因子的乘积，哈希表会进行rehash操作(内部数据结构会重建)
默认加载因子0.75是在时间和空间上的折衷，过高减少空间使用但会增加查询时间 .预期的条目和加载因子在初始化时应该被考虑进去，最大限度减少rehash操作。
如果最大容量大于最大条目除以加载因子，则不会发生rehash操作。 
 （map的哈希码是map的entrySet视图中的每个entry的哈希码之和）
 
 如果有大量的映射需要存在在hashMap中，创建足够空间的map比根据增长需要自动执行rehash操作更有效率。
 
 Map m = Collections.synchronizedMap(new HashMap(...)); 同步包装避免非同步访问 ，或对封装了该映射的对象进行同步。
 
 
 
 