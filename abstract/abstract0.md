#### Biological Foundation

If a group of neurons acts as a concept, we can represent that with lines that connect nodes in a concept map.
But from what I know that's it: there's absolutely no other way to infer anything else about the "structure" of how different neurons (and concepts) are connected
with each other. 
That means the first requirement of this project and the only foundation from where to start is this one:
>1. It has to have, at least, nodes connected with lines


*There are a lot of other background ideas going on with this project but all of them revolve around a central problem.
That means it's better to state it at the beginning in order to have something to base future knowledges on. *
#### Main problematic

What makes me want to rethink mind/concept maps is the fact that it's closely tied to a fixed spatial position.
That means, concepts in a map have a fixed position in a 2d space. 
If we look closely at how concept maps work and if we relate that to how we think, we end up with a lot of fun and interesting questions about the matter. 
* How do mental concepts relate to their representation on a 2d space? 
* What part of the human cognition does a mind map represent?

As a first grade computer engineering student I personally don't have the answers on that, and by the works of people like Eagleman ("Livewired")
or Dehaene ("How we learn") I'm pretty sure noone has. 
That leaves me with the qualitative and relatively easy choice of analyzing myself and looking for answers by looking 
at what my own mind does.

The result of the last sentences is that the knowledge elicited below this line will be born from intuition rather than from proven scientific facts.
Of course, scientific knowledge will most certainly have an important role in this project but, obviously, there's a high change of drifting away from the truth
whenever we follow an scientifically unproven intuition. 
I will try to underline the level of probability associated with what I write insead of giving the same level of "truth" to an intuition *and* a scientific
fact, yet I'm sure I will forget sometimes. Read carefully and be ready for logical fallacies/inaccuracies.


*back to the topic:*
#### Concepts on a 2d space

When we think about something, we take in consideration different concepts: if we look at a math problem we load our knowledge about maths, and when our wife
asks us to do the dishes[^1] we move our attention to our home. 
We can say to have many things on our mind, but we choose focus based on a hierarcy of how "alive" they are on our mind. 
It's pretty intuitive to say that something we thought of long time ago is mentally "dead", as dead as what we ate 3 days ago. 
In this moment, what is alive inside my mind are all the concepts regarding this project and other matters as "I should really study Taylor's series" (school)
or the dish that my neightbour needs to return us. Needless to say that this project is currently really alive.
But how is this related to a concept map[^2]? 

When we create a concept map, we have no issue whatsoever in locating the concept we are currently using. That means that an operation such as "Connecting 
the concept 'cat' in my mind map with a node called 'animal'" understates the process of "finding the part of the screen where I spatially put the box
containing the word 'cat'". 
It's such a simple process that it's instant. 
Yet, if we take a break for some days and then return to the concept map we created, we might find out that we can't instantly locate a concept anymore, which
brings to the apparently obvious conclusion that when we're creating a map about a subject, every concept we take into consideration for that map also has a 
spatial position associated with it; in particular: a spatial position on that map.


#### Associated position and liveliness

This "associated position" I'm talking about has to be of the same reason as to locating a recently used folder on our Desktop, which is probably an
extension of how we navigate around our home based on the associated position we have in mind for the keys we forgot. 
Interestingly, this might connect to the fact[^3] that as we are born we already have the ability to have a spatial representation of objects,
which means that even if we don't see an object anymore we still think it's there. Might it be that, for human mind, a desktop acts as a space just as a
the real world does? Probably, but that's not the scope of this project.

If we build a really large mind map we shouldn't have problems of finding the concepts we want to work on because, if we think about them, we already know
where they are because we associate them with a position.
Some might argue that it's easy to forget about something, and in this case it's obvious that someone forgets about where he put something. 

There comes liveliness: when we think about a concept, that concept becomes more alive (I'm pretty sure I can say "neurally" alive), and if we don't think about
it anymore it slowly dies. The more a concept is alive the more is difficult to forget the position of it, and this is supported by the fact that if two neurons
activate at the same time, the connection between them will be stronger -> I.e. the more we work at a concept on a mind map, the stronger the connection between
that concept and his associated position will be. Just as the more we use an object the better we know were it is. 

But that is not all because liveliness gives a potentially powerful tool we can't refuse to not include:
if we keep a track of (1) the concepts we are modifying or (2) looking at, we can really easily produce a heatmap of what concepts we are using more often
and which ones we don't. Let's say that "more dead" concepts are darker while more alive ones are more red: when we open a concept map we can easily see on
which part of it we were working on, and this opens a ton of possibilities such as "Dammit I forgot something, what could it be? Oh, let me look at the history
of what I was thinking about" or "I'm stuck. Isn't there something useful in some past inferences?".
Now that I look at it: the first example I gave is a really powerful and dangerous one, because with AI it might be possible in the nearest future to 
categorize what a person is currently doing. If we do that, then it's just a matter of storing those data in order to have a complete history 
of what a person did. Business models will rise with the voice of some voice assistant yelling "you forgot to put Rosemary on those potatoes" or "Your daughter
moved the keys you're searching in the other room"
Back to the implementation: 

1) It's.... intuitive. The problem is, when a "modification" is detected, to calibrate how that modification affects the liveliness level of that concept.
2) Guess what, we have eye-tracking technology! Noone seems to like privacy anyways! :D

> 2. There has to be a way to register and elaborate the liveliness of the concepts in the map. Eye tracking seems like a really nice solution. 



#### Limitation of liveliness

Sometimes, like in this moment, we get a "brilliant idea" based on a random concept that should have been dead and, therefore, not "thinkable". 
For example, while writing the previous part about cognition, I randomly thought of AI and made a statement about that. If I was working on a mind map,
"AI" would have been a dead concept and I would have needed to search for it. If it wasn't clear: I would really *hate* to search for a concept while I have a
brainwave. 

Future work: - solving brainwaves: procastinare i collegamenti di concetti ad altri giorni
             - ai: collegamenti automatici basati sulla semantica e potenziamente NLP
             

#### Brainwaves (Ideas)

While we are focusing on something, your subconscoius might connect that "something" with other subjects thus creating potential "brainwaves".
For example, while thinking about liveliness I got a brainwave about a possible implementation in AI.
It appears that, while we are awaken, those connections are made of a really low energy relatively to the high energy our main subject gets. That means
most of those brainwaves would get ignored because our attention mechanism thinks on something else, thus ignoring them.
Some of those ignored thoughts are just some nonsense intuitions that are better to be ignored; I'm sure tho that those intuitions are exactly what someone
would need for any research project or for a project like this. Perhaps those nonsense intuitions only need a really small amount of attention to become a
mind blowing idea.

I better stop writing because that is a really interesting subject to study and if I want to navigate it solely by intuition then I better start walking
on a minefield.
Guess what, a concept map would really help right there because of the exponentially increasing complexity I'm starting to feel in my mind. Thank god I can
filter those thoughts on what I need for this project.
To better give you an idea on the implications for this project, I will give you this link: <https://bigthink.com/articles/why-you-shouldnt-focus-too-much/> 
but I won't get any further than providing this basic ideas: 

1. Many concepts we have in our mind are not dead, yet they are made of so little energy/liveliness that we can't or won't focus on them.[^4]
   Example: AI is for me the greatest of those "surviving" concepts, which means I can feel it's alive in my consciousness but I'm not focusing on it, yet it's
   there to give me some ideas sometimes. [^5]
2. Those everlasting concepts might be affected by our everyday life. That means that the liveliness measure of a concept map would lose all its
   relevance because it's not able to track how those concpets lose/gain liveliness during the day (or even multiple days). 
   
To sum up, we have 2.5 problems:
1. The liveliness software would need to be smart enough to represent those "very low lively" concepts without classifying them as "dead".
1.5. The "eye-tracking" idea might be useless but It's gonna be implemented anyways; it's a problem that needs to be discussed after the first release of 
     this project, thus after playing and sperimenting with it. 
2. It doesn't appear to be avoidable the fact that, while working on a lively part of the project, we get a brainwave thus we want to bring in consideration
   an apparently dead concept. With many concepts, this results in having to search for that particular concept, which is the ever-lasting problematic I thought
   I could avoid with eye tracking. I guess it's time to bring it to focus once an for all. 
   
   
#### Resurrecting dead concepts
Procastinated for when I actually need it.

#### Goal
As I already states somewhere, the goal of this project is to represent cognition. 
With "cognition" I mean the lowest possible, yet appreciable, level of thoughts that happen in our mind.

An example of what I'm trying to achieve could be one where a concept mapper thinks a lot on how to represent something. 
In that case, that hypotetical concept mapper would need to spend a lot of time on the map in order to make it more understandable for other people. 
Yet, this is not the case: if someone uses the idea of this project on the example I just stated, then he would make a map based on the decisions he made to 
make a concept map.
This might be messy; here's a better representation of the level of cognition I want to represent:

         CONCEPT MAPPER ->  THOUGHTS  -> MAKES CONCEPTS
         "LIFE MAPPER" -> THINKS WHILE WRITIG THE THOUGHTS ON A "LIFEMAP" 
       
A skilled concept mapper has a lot of thoughts on how to make concept.
I want to represent the thoughts he has that make him/her create a concept map.

Riguardo alla fattibilità della cosa qualcuno avrà forse dei dubbi, ma se per l'uomo è facilissimo esprimere propri pensieri tramite l'uso del linguaggio 
(quando parliamo; in tempo reale) allora l'esprimere concetti in tempo reale dovrebbe essere solamente un estensione di questa abilità innata. 
Fatto sta che già riusciamo ad estendere la suddetta abilità quando scriviamo al computer a velocità abbastanza elevate,riuscendo dunque a scrivere in tempo
reale ciò che stiamo pensando.


[^1]: I'm single
[^2]: Note that I keep interchanging the terms "concept" and "mind" maps, even tho I know they are different. What I refer to when I use those therms is the
intuitive idea of the structure of concpet/facts connected to each other with nodes.
[^3]: nicely illustrated in the book of Dehaene
[^4]: Might it be that there's a mechanism in place in order to do just that? i.e. filtering thoughts if they are potential nonsense? That would prevent our neurons to bring up chain reactions and thus invoking concepts all around our brain, resulting in really messy concepts and ideas which results in nonsense, which is obviously not really ideal for survival. 
[^5]: I would really need either a psychologist or another contributor to analyze these points because I have no idea if that's subjective, thus it happens only in my brain.
