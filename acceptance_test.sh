#!/bin/bash
test $(curl 10.222.60.139:8765/sum?a=1\&b=2) -eq 3