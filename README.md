# gav

A Leiningen plugin to print the maven group/artifact id and version.

I've needed to grab these a few times for build-scripts, jenkins jobs,
etc. It's always fiddly so I thought I'd write a short plugin to do it.

## Usage

Put `[lein-gav "1.0.0"]` into the `:plugins` vector of your project.clj.

### Default output

group-id
artefact-id
version 

for example:

    $ lein gav
    com.example
    myproject
    0.0.1-SNAPSHOT

### Specifying the format

    $ lein gav "** {g} **\n-- {a} --\n__ {v} __"
    ** com.example **
    -- myproject --
    __ 0.0.1-SNAPSHOT __


### Slash-separated group-id

Might be useful for making things which are
shaped like maven repositories:

    $ mkdir -p $(lein gav '{gs}/{a}')

created the dirs `com`, `com/example` and `com/example/myproject`.

### Assigning to shell vars

    $ read G A V <<< $(lein gav '{g} {a} {v}')
    $ echo $G
    com.example

...etc. This works in bash and zsh at least.

### Extra output getting in the way?

Best to use lein once before, at least `lein deps`, to avoid having
output from other parts of lein affecting the output here.

## License

Copyright © 2015 Matthew Gilliard

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
