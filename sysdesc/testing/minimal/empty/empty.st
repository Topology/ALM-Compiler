------------------
-- SYMBOL TABLE --
------------------

-------------------
-- Sort Hierachy --
-------------------


sort.name: sort_hierarchy_nodes_
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:
universe
actions
booleans
integers

sort.location: [[NO TEXT] (0,0)]

sort.name: universe
sort.parents: 
sort.children: actions
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: booleans
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: actions
sort.parents: universe
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: integers
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

---------------------------
-- Constant Declarations --
---------------------------

---------------------------
-- Function Declarations --
---------------------------

subsort: sort_hierarchy_nodes_ * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

instance: universe * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

sink: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

link: sort_hierarchy_nodes_ * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

has_parent: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

has_child: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

source: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

occurs: actions -> booleans [[NO TEXT] (0,0)] fluent 

is_a: universe * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

