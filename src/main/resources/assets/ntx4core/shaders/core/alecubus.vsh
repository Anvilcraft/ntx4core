#version 150
// vim: ft=glsl

in vec3 Position;
in vec2 UV0;

uniform mat4 Mtx;

out vec2 texCoord;

void main() {
    gl_Position = Mtx * vec4(Position, 1.0);
    texCoord = UV0;
}
