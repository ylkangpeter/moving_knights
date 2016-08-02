# moving_knights
A common puzzle in computer games

Say there are 2 groups of kinghts standing in a line like this (only 3 knights in each group in this example and should be n for common case)

    111 222

'1' represents kinghts in group 1 while '2' represents kinghts in the other group. There is one step between these 2 groups.

Can you move the knights to 

    222 111

what you can do is:
* knights in group 1 can only move towards right and knights in group 2 can only move towards left
* when you move you can only do:
  * move 1 step forword if there is no knights in front you: 111 222 -> 11 1222
  * jump over 1 knight belongs to the other group in front you: 11 1222 -> 1121 22

There should be only 1 solution. Try to prove it.
