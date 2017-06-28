------------------
-- SYMBOL TABLE --
------------------

-------------------
-- Sort Hierachy --
-------------------


sort.name: integers
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: timeStep
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: universe
sort.parents: 
sort.children: points, actions, things
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: things
sort.parents: universe
sort.children: agents
sort.attributes:
sort.instances:

sort.location: [things (5:12)]

sort.name: agents
sort.parents: things
sort.children: 
sort.attributes:
sort.instances:
bob
john

sort.location: [agents (6:4)]

sort.name: sort_hierarchy_nodes_
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:
universe
timeStep
actions
booleans
integers
points
things
agents
move

sort.location: [[NO TEXT] (0,0)]

sort.name: points
sort.parents: universe
sort.children: 
sort.attributes:
sort.instances:
new_york
paris
rome

sort.location: [points (5:4)]

sort.name: booleans
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: actions
sort.parents: universe
sort.children: move
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: move
sort.parents: actions
sort.children: 
sort.attributes:
   origin: move -> points [origin:points (10:6)] attribute static 
   dest: move -> points [dest:points (11:6)] attribute static 
   actor: move -> agents [actor:agents (9:6)] attribute static 
sort.instances:
go(X, P1, P2)
go(X, P)

sort.location: [move (7:4)]

---------------------------
-- Constant Declarations --
---------------------------

---------------------------
-- Function Declarations --
---------------------------

transitive_connectivity:  -> booleans [transitive_connectivity:booleans (16:6)] static basic 

has_parent: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

loc_in: things -> points [totalloc_in:things->points (20:6)] total fluent basic 

connected: points * points -> booleans [connected:points*points->booleans (19:6)] fluent basic 

link: sort_hierarchy_nodes_ * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

has_child: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

origin: move -> points [origin:points (10:6)] attribute static 

is_a: universe * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

sink: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

actor: move -> agents [actor:agents (9:6)] attribute static 

occurs: actions -> booleans [[NO TEXT] (0,0)] fluent 

symmetric_connectivity:  -> booleans [symmetric_connectivity:booleans (15:6)] static basic 

dest: move -> points [dest:points (11:6)] attribute static 

source: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

instance: universe * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

subsort: sort_hierarchy_nodes_ * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

