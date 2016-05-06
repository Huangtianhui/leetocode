import os,os.path
from flask import Flask, request, render_template, redirect, url_for,make_response,send_file,session,abort
from werkzeug.utils import secure_filename
from flask.ext.bootstrap import Bootstrap
from os import listdir
from os.path import isfile, join
#from pymediainfo import MediaInfo


app = Flask(__name__, static_url_path='')
app.config['SECRET_KEY'] = 'asdfsafdsaf';
bootstrap = Bootstrap(app)




#show the main page
@app.route('/main')
def main():
    session['username']=''
    # or return redirect(url_for(main))
    return render_template('main.html')



@app.route('/signup', methods=['POST'])
def signup():

    if request.form['username']=='': 
        return render_template('main.html')
    else:
            # form=MyForm()
            # if form.validate_on_submit():
            #     flash("Success")
            #     session['username']=request.form['username']
            #     return redirect(url_for('message'))
            # return render_template("main.html",form=form)
        session['username'] = request.form['username']
        return redirect(url_for('message'))


@app.route('/message')
def message():
    #for upload page should have upload page and username and files
    filelist = [f for f in listdir('./static/Uploads/') if isfile(join('./static/Uploads/', f))]
    return render_template('upload.html', username=session['username'],list=filelist)



# UPLOAD_FOLDER = '/path/to/the/uploads'
# ALLOWED_EXTENSIONS = set(['txt', 'pdf', 'png', 'jpg', 'jpeg', 'gif'])

# app = Flask(__name__)
# app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
# def allowed_file(filename):
#     return '.' in filename and \
#            filename.rsplit('.', 1)[1] in ALLOWED_EXTENSIONS


# @app.route('/', methods=['GET', 'POST'])
# def upload_file():
#     if request.method == 'POST':
#         file = request.files['file']
#         if file and allowed_file(file.filename):
#             filename = secure_filename(file.filename)
#             file.save(os.path.join(app.config['UPLOAD_FOLDER'], filename))
#             return redirect(url_for('uploaded_file',
#                                     filename=filename))
#     return '''

@app.route('/upload', methods=['GET', 'POST'])
def upload():
    filelist = [f for f in listdir('./static/Uploads/') if isfile(join('./static/Uploads/', f))]
    #update the page and show the content
    if request.method == 'GET':
        return render_template('upload.html',list=filelist)
    #upload the file
    elif request.method == 'POST':
        f = request.files['file']
        file_name = secure_filename(f.filename)
        f.save(os.path.join('./static/Uploads', file_name))
        return redirect(url_for('upload'))

@app.route('/test')
def download():
    re=make_response(request.args['files'])
    return re


# @app.route('/media',methods=['GET','POST'])
# def media():
#     media_info = MediaInfo.parse('my_video_file.mov')
#     for track in media_info.tracks:
#         if track.track_type == 'Video':

#             #track containstrack.bit_rate, track.bit_rate_mode, track.codec
#             return redirect(url_for('upload'),track)



if __name__ == '__main__':
    app.run(debug=True)