var path = require('path');

module.exports = {
  entry: ['whatwg-fetch', './src/main/js/app.js'],
  devtool: 'sourcemaps',
  cache: true,
  mode: 'development',
  output: {
      path: __dirname,
      filename: './src/main/resources/static/built/bundle.js'
  },
  module: {
    rules: [
    	{
        test: /\.(js|jsx)$/,
        exclude: /(node_modules)/,
        use: [{
            loader: 'babel-loader',
            options: {
                presets: ['@babel/preset-env', '@babel/preset-react']
            }
        }]
      },
      {
          test: /\.css$/,
          use: ['style-loader', 'css-loader'],
      },
    ]
  }
};