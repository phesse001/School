import numpy as np
import matplotlib.pyplot as plt
import time
import os

x = [100,200,300]
y = [358,723,1066]


plt.scatter(x,y)
plt.plot(x,y)
plt.title("Tickets vs Ticks")
plt.xlabel("Number of Tickets")
plt.ylabel("Number of Ticks")
plt.show()
#plt.savefig("test_fig.png")