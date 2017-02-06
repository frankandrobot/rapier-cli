# rapier-cli
## Proposed Interface

- a main `rapier.conf` configuration
- a master/blank template
- a set of training examples
- a set of documents

```bash
rapier-cli learn # learn from training examples
rapier-cli apply # apply learned rules to docs
```

### Main Configuration - rapier.conf

```json
{
  "params": {
    "maxOuterLoopFails": //...,
    "compressionRandomPairs": //...,
    //...
    //see rapier for details
  }, 
  "masterTemplateUri" : "absolute or relative path to master/blank template",
  "trainingDataUri": "absolute or relative path to training directory",
  "learnedRulesUri": "absolute or relative path where rapier stores learned rules",
  "dataUri": "absolute or relative path to data (what rapier runs against)"
}
```

### Master Template 

```json
{
  "name": "the master/blank template name",
  "slots": [
    "title",
    "salary",
    //...
  ] 
}
```

### Training Example

```json
{
  "document": "the document",
  "filledTemplate": {
     "title": [
       "Senior Software Engineer", 
       "Junior Engineer",
       //...
       ],
     "salary": [
       "60k",
       "120k",
       //...
     ]
  }
}
```

### Document

-  Just a plain text document.

