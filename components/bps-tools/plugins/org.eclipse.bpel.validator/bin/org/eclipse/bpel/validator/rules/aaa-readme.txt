These are the "rules" which we use to validate BPEL code. 

The assumptions about code in this package is that:

1) Rules are dependent only on the validator model API (and the JDK)

2) Rules are placed in classes, conveniently broken down
    to match the nodes in a "typical" BPEL model tree.
    The names of the actual BPEL nodes are used here.

3) The code that executes the rules in the right order is in Validator,
the base class of this hierarchy.

4) All problems produced by the rules are IProblem instances which 
   can be easily adapted to just about anything you want to show.
   IProblem instances derive some of their information from the BPEL 
   model objects (such as line numbers, XPaths, etc).
   

There should be no dependency on actual BPEL model API (EMF, DOM, xyz) whatever
in this package. 

The BPEL validator model API provides the simple INode facade. The other important
interfaces which are used in the validator is in org.eclispe.bpel.validator.model
