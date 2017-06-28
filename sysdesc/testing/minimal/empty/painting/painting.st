------------------
-- SYMBOL TABLE --
------------------

-------------------
-- Sort Hierachy --
-------------------


sort.name: universe
sort.parents: 
sort.children: things, actions, points
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: actions
sort.parents: universe
sort.children: move, grasp, release
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: grasp
sort.parents: actions
sort.children: 
sort.attributes:
   grasped_thing: grasp -> things [grasped_thing:things (44:6)] attribute static 
   grasper: grasp -> agents [grasper:agents (43:6)] attribute static 
sort.instances:
grasp(C)

sort.location: [grasp (41:4)]

sort.name: move
sort.parents: actions
sort.children: carry, climb
sort.attributes:
   actor: move -> agents [actor:agents (9:6)] attribute static 
   origin: move -> points [origin:points (10:6)] attribute static 
   dest: move -> points [dest:points (11:6)] attribute static 
sort.instances:
move(P)

sort.location: [move (7:4)]

sort.name: climb
sort.parents: move
sort.children: 
sort.attributes:
   elevation: climb -> elevations [elevation:elevations (78:6)] attribute static 
sort.instances:
climb(box)

sort.location: [climb (76:4)]

sort.name: integers
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: things
sort.parents: universe
sort.children: carriables, elevations, agents
sort.attributes:
sort.instances:

sort.location: [things (5:12)]

sort.name: agents
sort.parents: things
sort.children: 
sort.attributes:
sort.instances:

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
carriables
carry
grasp
release
elevations
climb
floor_points
ceiling_points
movable_points

sort.location: [[NO TEXT] (0,0)]

sort.name: booleans
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: points
sort.parents: universe
sort.children: ceiling_points, floor_points, movable_points
sort.attributes:
sort.instances:

sort.location: [points (5:4)]

sort.name: floor_points
sort.parents: points
sort.children: 
sort.attributes:
sort.instances:
under_banana
initial_monkey
initial_box

sort.location: [floor_points (89:4)]

sort.name: timeStep
sort.parents: 
sort.children: 
sort.attributes:
sort.instances:

sort.location: [[NO TEXT] (0,0)]

sort.name: movable_points
sort.parents: points
sort.children: 
sort.attributes:
sort.instances:
top(box)

sort.location: [movable_points (89:34)]

sort.name: carriables
sort.parents: things
sort.children: 
sort.attributes:
sort.instances:

sort.location: [carriables (37:4)]

sort.name: ceiling_points
sort.parents: points
sort.children: 
sort.attributes:
sort.instances:
initial_banana

sort.location: [ceiling_points (89:18)]

sort.name: elevations
sort.parents: things
sort.children: 
sort.attributes:
sort.instances:

sort.location: [elevations (75:4)]

sort.name: release
sort.parents: actions
sort.children: 
sort.attributes:
   released_thing: release -> things [released_thing:things (48:6)] attribute static 
   releaser: release -> agents [releaser:agents (47:6)] attribute static 
sort.instances:
release(C)

sort.location: [release (45:4)]

sort.name: carry
sort.parents: move
sort.children: 
sort.attributes:
   carried_object: carry -> carriables [carried_object:carriables (40:6)] attribute static 
sort.instances:
carry(box, P)

sort.location: [carry (38:4)]

---------------------------
-- Constant Declarations --
---------------------------

const.name: banana
const.sorts: carriables
const.loc: [banana:carriables (93:4)]


const.name: box
const.sorts: carriables, elevations
const.loc: [box:carriables,elevations (92:4)]


const.name: monkey
const.sorts: agents
const.loc: [monkey:agents (91:4)]


const.name: top
const.sorts: points
const.loc: [top(elevations):points (80:4)]


---------------------------
-- Function Declarations --
---------------------------

has_parent: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

transitive_connectivity:  -> booleans [transitive_connectivity:booleans (16:6)] static basic 

loc_in: things -> points [totalloc_in:things->points (20:6)] total fluent basic 

carried_object: carry -> carriables [carried_object:carriables (40:6)] attribute static 

holding: agents * things -> booleans [totalholding:agents*things->booleans (52:6)] total fluent basic 

link: sort_hierarchy_nodes_ * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

connected: points * points -> booleans [connected:points*points->booleans (19:6)] fluent basic 

has_child: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

actor: move -> agents [actor:agents (9:6)] attribute static 

grasped_thing: grasp -> things [grasped_thing:things (44:6)] attribute static 

occurs: actions -> booleans [[NO TEXT] (0,0)] fluent 

symmetric_connectivity:  -> booleans [symmetric_connectivity:booleans (15:6)] static basic 

instance: universe * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

subsort: sort_hierarchy_nodes_ * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

releaser: release -> agents [releaser:agents (47:6)] attribute static 

released_thing: release -> things [released_thing:things (48:6)] attribute static 

elevation: climb -> elevations [elevation:elevations (78:6)] attribute static 

is_held: things -> booleans [is_held:things->booleans (54:6)] fluent defined 

under: floor_points * things -> booleans [under:floor_points*things->booleans (97:6)] static basic 

origin: move -> points [origin:points (10:6)] attribute static 

sink: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

is_a: universe * sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

grasper: grasp -> agents [grasper:agents (43:6)] attribute static 

dest: move -> points [dest:points (11:6)] attribute static 

source: sort_hierarchy_nodes_ -> booleans [[NO TEXT] (0,0)] static 

can_reach: agents * things -> booleans [can_reach:agents*things->booleans (55:6)] fluent defined 

