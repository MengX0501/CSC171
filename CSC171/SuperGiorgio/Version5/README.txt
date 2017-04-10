
This version refactors the sprites into a hierarchy of Sprite classes.

The next thing would be to move the common code for changing images into the Sprite
class, with flags for whether there's one image, a looping sequence, or a fwd-bwd sequence.

This is actually a textbook example of a situation where Java's single inheritance model and lack of so-called ``mix-in'' classes makes refactoring difficult.
