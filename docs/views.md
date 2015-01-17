Views are defined using
[Selmer](https://github.com/yogthos/Selmer) (a Django inspired template system)
and are located under `resources/templates`. The namespace `app.views.layout`
contains some helper functions for rendering view (`render` function). Of course,
you can use any other template library engine that you want

```
(render "home/index.html" {:name "some arguments"})
```

**Note**: the `clj` folder under `templates` directory contains some templates
  for generating clojure code files (like models, controllers). You should not
  use this folder for rendering web page template.
