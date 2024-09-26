import psutil
from flask import Flask, render_template
import logging

# Setup logging
logging.basicConfig(filename='resource_warnings.log', level=logging.WARNING)

app = Flask(__name__)

def get_top_n_processes(n=5):
    # Get processes sorted by CPU usage
    processes = sorted(psutil.process_iter(['pid', 'name', 'cpu_percent', 'memory_percent']),
                       key=lambda p: p.info['cpu_percent'], reverse=True)
    return processes[:n]

@app.route("/")
def index():
    cpu_metric = psutil.cpu_percent(interval=1)
    mem_metric = psutil.virtual_memory().percent
    warning_message = None

    if cpu_metric > 70 or mem_metric > 70:
        warning_message = "High CPU or Memory Detected, scale up brotha!"
        top_consumers = get_top_n_processes(5)
        logging.warning(f"High Resource Usage Detected! CPU: {cpu_metric}%, Memory: {mem_metric}%")
        for proc in top_consumers:
            logging.warning(f"PID: {proc.info['pid']}, Name: {proc.info['name']}, "
                            f"CPU: {proc.info['cpu_percent']}%, Memory: {proc.info['memory_percent']}%")

    return render_template("index.html", cpu_metric=cpu_metric, mem_metric=mem_metric, message=warning_message)

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
