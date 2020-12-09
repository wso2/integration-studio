Code in this package should have no dependency on things other then the JDK.

It represents the validator model API to which all the rules are written.

The model API makes certain assumptions:

 1) The structure validated is a tree structure with basic tree navigation
 
 2) Each node in the tree has a corresponding node validator
     (So a Variable has a VariableValidator)
     
 3) It has no dependency on anything else other then the JDK. 
 
Interfaces in this model need to be adapted on both the input and output
sides. Typically this would invovle:
 
  input side:  INode, IModelQuery, IFunctionMeta 
  output side: IProblem


