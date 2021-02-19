# DataStructures

<h4><u>Dynamic array:</u></h4>
<p>An array that changes depending on input quantities. 
These are best used for storing data with unknown limits.
The opportunity cost of dynamic arrays can be over allocation 
of memory, or the time it takes to iterate through the list (severity of
this depends on list architecture.</p>

<h4><u>Stack:</u></h4>
<p>Stacks, aka Last-in-First-out (LIFO), allow you to control
your data in a different way than a list. 
<br>Common Uses are:<ol>
<li>Recursive methods</li>
<li>establishing order of operations</li>
</ol></p>


<h4><u>Queue:</u></h4>
<p>Queue, aka Last-in_last-out (LILO), allows you to process 
entries like a checkout-line. A common use for queues is moving through
"GET request" entering an API. This way the order in which the
requests are received are retained by time-of-request.
<br>Common Uses are:<ol>
<li>APIs (ya i said this already, but fuck you, this is my README)</li>
<li>Undo buttons</li>
</ol></p>

<h4><u>Singly/Doubly linked list:</u></h4>
<p>Linked list offer a lot of the same functionalities as dynamic arrays,
however they are implemented by connected nodes instead of primitive arrays. 
This inherent quality makes them perfect for retention of entries that are related contiguously,
such as navigating the "back" and "forward" buttons on your browser.
<br>Common Uses are:<ol>
<li>Curricular linked list</li>
<li>Implementing Stacks b/c it maintains a "head"</li>
</ol></p>

