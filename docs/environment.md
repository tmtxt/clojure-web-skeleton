Environment variables are defined in `project.clj` file and can be retrieved
using [Environ](https://github.com/weavejester/environ) as follow

- project.clj

```
(defproject
  ...
  :profiles
  {:production
   {:env
    {:someconfig "production"}}

   :dev
   {:env
    {:someconfig "dev"}}})
```

- to get it

```
(require '[environ.core :refer [env]])

(env :database-url)
```
