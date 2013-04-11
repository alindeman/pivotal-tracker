# pivotal-tracker

A Clojure library for interacting with the Pivotal Tracker API (v3)

## Installation

Clojars? I haven't actually released it yet.

## Usage

### Require It

```clojure
(ns my-app.core
  (:require [pivotal-tracker.client :as client]))
```

### List of Projects

```clojure
(client/projects "APITOKEN")
```

### Specific Project (by ID)

```clojure
(client/project "APITOKEN" 12345)
```

### List of Stories (by Project ID)

```clojure
(client/stories "APITOKEN" 12345)
```

With filtering parameters

```clojure
(client/stories "APITOKEN" 12345 {:filter "state:started"})
```

## License

Copyright © 2013 Andy Lindeman

Distributed under the MIT License.
