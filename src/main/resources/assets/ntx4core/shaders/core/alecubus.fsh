#version 150
// vim: ft=glsl

uniform vec4 ColorModulator;
uniform sampler2D Sampler0;

in vec2 texCoord;
out vec4 fragColor;

void main() {
    fragColor = texture(Sampler0, texCoord) * ColorModulator;
}
