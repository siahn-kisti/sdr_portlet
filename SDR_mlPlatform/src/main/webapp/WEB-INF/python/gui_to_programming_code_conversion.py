
# coding: utf-8

# In[2]:


import sys
import json
import RCodeGenerator as RGen
import PythonCodeGenerator as PyGen

# GUI parameters loading part
json_file_path = sys.argv[1] # "./"
json_file_number = sys.argv[2] # userId "123"
json_file_name = "_gui_parameters.json"

with open(json_file_path+json_file_number+json_file_name) as data_file:
    gui_params = json.load(data_file)


# In[5]:


if gui_params['kernel'] == 'R':
    generated_code = RGen.from_gui_to_code(gui_params)
elif gui_params['kernel'] == 'Python':
    generated_code = PyGen.from_gui_to_code(gui_params)
else:
    generated_code = '[ERR] Empty kernel!'


# In[6]:


print(generated_code)


# In[ ]:





# In[ ]:




